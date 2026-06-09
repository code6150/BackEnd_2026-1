package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BoardService {

    private final BoardRepository boards;

    public BoardService(BoardRepository boardRepository) {
        this.boards = boardRepository;
    }

    public HashMap<Long, ArticleBoard> getMembers() {
        return boards.findAll();
    }

    public void updateMember(Long id, ArticleBoard updatedBoard) {
        ArticleBoard modifiedBoard = boards.findAll().get(id);
        modifiedBoard.modifyBoard(
                updatedBoard.getBoardName()
        );
        boards.findAll().put(id, modifiedBoard);
    }

    public void creatBoard(String boardName) {
        ArticleBoard newBoard = new ArticleBoard(boardName);
        boards.findAll().put(newBoard.getId(), newBoard);
    }

    public void deleteBoard(Long id) {
        boards.findAll().remove(id);
    }

}
