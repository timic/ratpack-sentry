package com.github.timic.ratpack.sentry;

import com.google.common.collect.ImmutableMap;
import io.sentry.Sentry;
import io.sentry.event.Breadcrumb;
import io.sentry.event.BreadcrumbBuilder;
import ratpack.exec.ExecInterceptor;
import ratpack.exec.Execution;
import ratpack.func.Block;

/**
 * Logs raptack execution switching to sentry breadcrumbs.
 */
public final class SentryInterceptor implements ExecInterceptor {

  public static SentryInterceptor instance() {
    return new SentryInterceptor();
  }

  private SentryInterceptor() {
  }

  @Override
  public void intercept(Execution execution, ExecType execType, Block executionSegment) throws Exception {
    Breadcrumb breadcrumb = new BreadcrumbBuilder()
        .setCategory("ratpack_execution")
        .setData(ImmutableMap.of("exec_type", execType.name()))
        .build();
    Sentry.getContext().recordBreadcrumb(breadcrumb);
    executionSegment.execute();
  }

}
