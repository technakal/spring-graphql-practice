package com.technakal.bootstrap.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WoofWoofNotFoundException extends RuntimeException implements GraphQLError {

  private Map<String, Object> extensions = new HashMap<>();

  public WoofWoofNotFoundException(String message, Long invalidId) {
    super(message);
    extensions.put("invalidLocationId", invalidId);
  }

  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }

  @Override
  public ErrorType getErrorType() {
    return null;
  }
}
