package com.teams.project.core.utilities.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Result{
    private boolean success;
    private String message;
    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public Result(boolean success) {
        this.success = success;
    }

}
