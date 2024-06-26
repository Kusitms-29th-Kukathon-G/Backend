package com.kukathon.teamg.domain.sample.service;

import com.kukathon.teamg.common.error.ApplicationException;
import com.kukathon.teamg.domain.sample.dto.response.CreateSampleResponseDto;
import com.kukathon.teamg.domain.sample.entity.Sample;
import com.kukathon.teamg.domain.sample.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.kukathon.teamg.common.error.ErrorCode.DUPLICATE_SAMPLE_TEXT;

@RequiredArgsConstructor
@Service
@Transactional
public class SampleService {

    private final SampleRepository sampleRepository;

    public CreateSampleResponseDto createSample(String text) {
        validateDuplicateText(text);
        Sample sample = saveText(text);
        return CreateSampleResponseDto.of(sample);
    }

    private void validateDuplicateText(String text) {
        if(sampleRepository.existsByText(text)) {
            throw new ApplicationException(DUPLICATE_SAMPLE_TEXT);
        }
    }
    private Sample saveText(String text) {
        Sample sample = Sample.createSample(text);
        sampleRepository.save(sample);
        return sample;
    }
}
