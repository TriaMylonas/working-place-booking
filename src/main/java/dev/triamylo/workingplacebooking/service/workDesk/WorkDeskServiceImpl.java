package dev.triamylo.workingplacebooking.service.workDesk;

import dev.triamylo.workingplacebooking.model.WorkDesk;
import dev.triamylo.workingplacebooking.repository.WorkDeskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkDeskServiceImpl implements WorkDeskService {

    private final WorkDeskRepository workDeskRepository;

    public WorkDeskServiceImpl(WorkDeskRepository workDeskRepository) {
        this.workDeskRepository = workDeskRepository;
    }

    @Override
    public List<WorkDesk> list() {
        return workDeskRepository.findAll();
    }

    @Override
    public WorkDesk get(String id) {
        return workDeskRepository.findById(id).orElse(null);
    }

    @Override
    public void add(WorkDesk workDesk) {
        workDeskRepository.save(workDesk);
    }

    @Override
    public boolean delete(WorkDesk workDesk) {

        Optional<WorkDesk> existingWorkDesk = workDeskRepository.findById(workDesk.getId());

        if (existingWorkDesk.isPresent()) {
            workDeskRepository.delete(existingWorkDesk.get());
            return true;
        }

        return false;
    }

    @Override
    public boolean update(WorkDesk workDesk) {
        Optional<WorkDesk> existingWorkDesk = workDeskRepository.findById(workDesk.getId());

        if (existingWorkDesk.isPresent()) {
            WorkDesk updatedWorkDesk = existingWorkDesk.get();
            updatedWorkDesk.setNumber(workDesk.getNumber());
            updatedWorkDesk.setDescription(workDesk.getDescription());
            workDeskRepository.save(updatedWorkDesk);
            return true;
        }
        return false;
    }
}
