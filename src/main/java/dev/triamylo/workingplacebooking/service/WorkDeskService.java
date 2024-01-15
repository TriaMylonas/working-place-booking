package dev.triamylo.workingplacebooking.service;

import dev.triamylo.workingplacebooking.model.WorkDesk;

import java.util.List;

public interface WorkDeskService {

    List<WorkDesk> list();

    WorkDesk get(String id);

    void add(WorkDesk workDesk);

    boolean delete(WorkDesk workDesk);

    boolean update(WorkDesk workDesk);

}
