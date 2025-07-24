package com.sadat.NIC.Service;

import com.sadat.NIC.Entity.GrievanceResponse;
import com.sadat.NIC.Repository.GrievanceResponseRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GrievanceResponseService {
    private final GrievanceResponseRepository responseRepository;

    public GrievanceResponseService(GrievanceResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    public GrievanceResponse addResponse(GrievanceResponse response) {
        return responseRepository.save(response);
    }

    public List<GrievanceResponse> getResponsesByGrievanceId(Long grievanceId) {
        return responseRepository.findAllByGrievance_Id(grievanceId);
    }
}
