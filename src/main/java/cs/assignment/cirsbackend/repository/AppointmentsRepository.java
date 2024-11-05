package cs.assignment.cirsbackend.repository;

import cs.assignment.cirsbackend.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {
    // You can add custom query methods here if needed
}
