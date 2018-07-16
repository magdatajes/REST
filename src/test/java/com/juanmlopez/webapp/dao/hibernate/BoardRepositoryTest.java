package com.juanmlopez.webapp.dao.hibernate;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.juanmlopez.webapp.WebApp;
import com.juanmlopez.webapp.dao.BoardRepository;
import com.juanmlopez.webapp.domain.Board;
import com.juanmlopez.webapp.exception.DaoException;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApp.class)
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @After
    public void tearDown() throws DaoException {
        boardRepository.deleteAll();
    }

    @Test
    public void testGetBoardNotFound() throws DaoException {
        assertTrue(boardRepository.findByNombre("not found").isEmpty());
    }

    @Test
    public void testAddBoard() throws DaoException {
        String name = "name";
        Board board = new Board(name);
        boardRepository.save(board);

        List<Board> found = boardRepository.findByNombre(name);
        assertFalse(found.isEmpty());
        assertEquals(name, found.stream().findFirst().get().getName());
    }

}

