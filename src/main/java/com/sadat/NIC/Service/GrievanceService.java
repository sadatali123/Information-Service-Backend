package com.sadat.NIC.Service;

import com.sadat.NIC.Entity.Grievance;
import com.sadat.NIC.Repository.GrievanceRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GrievanceService {
    private final GrievanceRepository grievanceRepository;

    public GrievanceService(GrievanceRepository grievanceRepository) {
        this.grievanceRepository = grievanceRepository;
    }

    public Grievance addGrievance(Grievance grievance) {
        return grievanceRepository.save(grievance);
    }

    public Optional<Grievance> getById(Long id) {
        return grievanceRepository.findById(id);
    }

    public List<Grievance> getAll() {
        return grievanceRepository.findAll();
    }

    public Grievance updateStatus(Long id, Grievance.Status newStatus) {
        Optional<Grievance> grievanceOpt = grievanceRepository.findById(id);
        if (grievanceOpt.isPresent()) {
            Grievance grievance = grievanceOpt.get();
            grievance.setStatus(newStatus);
            grievance.setUpdatedAt(java.time.LocalDateTime.now());
            return grievanceRepository.save(grievance);
        }
        return null;
    }

    public void delete(Long id) {
        grievanceRepository.deleteById(id);
    }
}