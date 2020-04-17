package com.auto.dao;

import java.util.List;

import com.auto.entity.Log;

public interface LogDAO {

	void addLogToDatabase(String logType, String logMessage);

	List<Log> getLogsFromDatabase();

}
