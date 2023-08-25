package com.apartnoise.service;

import com.apartnoise.model.Apart;
import com.apartnoise.persist.ApartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApartService {

    private final ApartRepository apartRepository;

    public List<Apart> getApartService(String name) {
        if (name.isBlank())
            return apartRepository.findAll();
        else
            return apartRepository.findByApartnameLikeOrderByIDDesc(name);
    }

    public String createApartService(Apart apart) {
        apartRepository.save(apart);
        return "등록 완료";
    }

    public String deleteApartService(Long id) {
        Optional<Apart> apartOptional = apartRepository.findById(id);

        if (apartOptional.isPresent()) {
            apartRepository.delete(apartOptional.get());
            return "삭제 완료";
        } else {
            return "해당 아파트를 찾을 수 없습니다";
        }
    }
}