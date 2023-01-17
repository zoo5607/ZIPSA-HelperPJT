package com.sparta.zipsa.controller;

import com.sparta.zipsa.dto.BoardRequestDto;
import com.sparta.zipsa.dto.BoardResponseDto;
import com.sparta.zipsa.entity.User;
import com.sparta.zipsa.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
@PreAuthorize("hasRole('ROLE_HELPER') or hasRole('ROLE_CUSTOMER') or hasRole('ROLE_ADMIN')")

public class  BoardController {
    private final BoardService boardService;
    @PostMapping
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto boardRequest, @AuthenticationPrincipal User user)
    {
        return boardService.createBoard(boardRequest,user);
    }

}
