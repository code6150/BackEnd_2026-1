package com.example.demo.Board;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BoardService {

    private final BoardRepository boards;

    public BoardService(BoardRepository boardRepository) {
        this.boards = boardRepository;
    }

    public HashMap<Long, Board> getBoards() {
        return boards.findAll();
    }

    public void updateBoard(Long id, Board updatedBoard) {
        Board modifiedBoard = boards.findAll().get(id);
        modifiedBoard.modifyBoard(
                updatedBoard.getBoardName()
        );
        boards.findAll().put(id, modifiedBoard);
    }

    public void creatBoard(String boardName) {
        Board newBoard = new Board(boardName);
        boards.findAll().put(newBoard.getId(), newBoard);
    }

    public void deleteBoard(Long id) {
        boards.findAll().remove(id);
    }

}
