package com.sadat.NIC.Service;
// package com.sadat.grievancemanagement.service;

// import com.sadat.grievancemanagement.entity.EmergencyReport;
// import com.sadat.grievancemanagement.repository.EmergencyReportRepository;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class EmergencyReportService {
//     private final EmergencyReportRepository emergencyRepository;

//     public EmergencyReportService(EmergencyReportRepository emergencyRepository) {
//         this.emergencyRepository = emergencyRepository;
//     }

//     public EmergencyReport submitReport(EmergencyReport report) {
//         return emergencyRepository.save(report);
//     }

//     public Optional<EmergencyReport> getById(Long id) {
//         return emergencyRepository.findById(id);
//     }

//     public List<EmergencyReport> getAll() {
//         return emergencyRepository.findAll();
//     }

//     public EmergencyReport updateStatus(Long id, EmergencyReport.Status newStatus) {
//         Optional<EmergencyReport> reportOpt = emergencyRepository.findById(id);
//         if (reportOpt.isPresent()) {
//             EmergencyReport report = reportOpt.get();
//             report.setStatus(newStatus);
//             if (newStatus == EmergencyReport.Status.RESOLVED) {
//                 report.setResolvedAt(java.time.LocalDateTime.now());
//             }
//             return emergencyRepository.save(report);
//         }
//         return null;
//     }
// }