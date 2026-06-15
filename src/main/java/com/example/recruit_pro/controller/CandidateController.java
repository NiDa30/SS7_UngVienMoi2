package com.example.recruit_pro.controller;

import com.example.recruit_pro.dto.CandidateCreateDTO;
import com.example.recruit_pro.dto.CandidateUpdateDTO;
import com.example.recruit_pro.entity.Candidate;
import com.example.recruit_pro.service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @PutMapping("/update/{id}")
    public ResponseEntity<Candidate> updateCandidate(
            @PathVariable Long id,
            @Valid @ModelAttribute CandidateUpdateDTO dto) {
        Candidate updatedCandidate = candidateService.updateCandidate(id, dto);
        return ResponseEntity.ok(updatedCandidate);
    }

    @PostMapping
    public ResponseEntity<Candidate> registerCandidate(@Valid @RequestBody CandidateCreateDTO dto) {
        Candidate savedCandidate = candidateService.registerCandidate(dto);
        return ResponseEntity.ok(savedCandidate);
    }
}
