package com.polytech.polytoDo.business;

import java.util.List;

public interface FeedService {
    List<Task> fetchAll(String username);
}
