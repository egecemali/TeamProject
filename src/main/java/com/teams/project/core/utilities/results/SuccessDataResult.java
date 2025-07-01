package com.teams.project.core.utilities.results;

public class SuccessDataResult<T> extends DataResult{

    public SuccessDataResult(Object data, String message) {
        super(data, true, message);
    }

    public SuccessDataResult(Object data) {
        super(data, true);
    }
}
