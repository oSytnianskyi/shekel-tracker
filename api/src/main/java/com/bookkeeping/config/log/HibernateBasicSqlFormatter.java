package com.bookkeeping.config.log;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

public class HibernateBasicSqlFormatter implements MessageFormattingStrategy {
  private final SqlFormatter sqlFormatter = new BasicFormatterImpl();

  @Override
  public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
    String res = !sql.isEmpty() ? sql : prepared;
    if (res.isEmpty()) {
      return "";
    }
    String template = "Hibernate: %s %s {Elapsed time: %sms}";
    String batch = "batch".equals(category) ? "batch operation" : "";
    return String.format(template, batch, sqlFormatter.format(res), elapsed);
  }
}
