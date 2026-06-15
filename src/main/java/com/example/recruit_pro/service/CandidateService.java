package com.example.recruit_pro.service;

import com.example.recruit_pro.dto.CandidateCreateDTO;
import com.example.recruit_pro.dto.CandidateUpdateDTO;
import com.example.recruit_pro.entity.Candidate;
import com.example.recruit_pro.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public Candidate updateCandidate(Long id, CandidateUpdateDTO dto) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        candidate.setAddress(dto.getAddress());
        candidate.setBio(dto.getBio());

        return candidateRepository.save(candidate);
    }

    public Candidate registerCandidate(CandidateCreateDTO dto) {
        if (candidateRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Candidate candidate = Candidate.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .age(dto.getAge())
                .yearsOfExperience(dto.getYearsOfExperience())
                .build();

        return candidateRepository.save(candidate);
    }
}
