package com.auto.service;

import java.util.List;

import com.auto.entity.Log;

public interface LogService {

	void addLogToDatabase(String logType, String logMessage);

	List<Log> getLogsFromDatabase();

}
