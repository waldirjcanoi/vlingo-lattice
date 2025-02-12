// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.lattice.model.process;

import java.util.List;
import java.util.function.Supplier;

import io.vlingo.lattice.model.Command;
import io.vlingo.lattice.model.DomainEvent;
import io.vlingo.symbio.Source;

/**
 * Definition for a long-running process.
 * @param <T> my state type
 */
public interface Process<T> {
  /**
   * Answer my state as a {@code Chronicle<T>}.
   * @return {@code Chronicle<T>}
   */
  Chronicle<T> chronicle();

  /**
   * Answer my id, which is used for correlation among my collaborators.
   * @return String
   */
  String id();

  /**
   * Emit the {@code command} by persisting it as a {@code ProcessMessage}.
   * <p>
   * Uses the underlying persistence mechanism to
   * ensure the {@code command} is permanent, enabling
   * a backing {@code Exchange} message to be enqueued
   * with guaranteed delivery semantics.
   * @param command the Command to apply
   */
  void emit(final Command command);

  /**
   * Emit the {@code command} by persisting it as a {@code ProcessMessage},
   * followed by the execution of a possible {@code andThen}.
   * <p>
   * Uses the underlying persistence mechanism to
   * ensure the {@code command} is permanent, enabling
   * a backing {@code Exchange} message to be enqueued
   * with guaranteed delivery semantics.
   * @param command the Command to apply
   * @param andThen the {@code Supplier<R>} executed following the application of command
   * @param <R> the return type of the andThen {@code Supplier<R>}
   */
  <R> void emit(final Command command, final Supplier<R> andThen);

  /**
   * Emit the {@code event} by persisting it as a {@code ProcessMessage}.
   * <p>
   * Uses the underlying persistence mechanism to
   * ensure the {@code event} is permanent, enabling
   * a backing {@code Exchange} message to be enqueued
   * with guaranteed delivery semantics.
   * @param event the DomainEvent to apply
   */
  void emit(final DomainEvent event);

  /**
   * Emit the {@code event} by persisting it as a {@code ProcessMessage},
   * followed by the execution of a possible {@code andThen}.
   * <p>
   * Uses the underlying persistence mechanism to
   * ensure the {@code event} is permanent, enabling
   * a backing {@code Exchange} message to be enqueued
   * with guaranteed delivery semantics.
   * @param event the DomainEvent to apply
   * @param andThen the {@code Supplier<R>} executed following the application of event
   * @param <R> the return type of the andThen {@code Supplier<R>}
   */
  <R> void emit(final DomainEvent event, final Supplier<R> andThen);

  /**
   * Emit the {@code sources} by persisting each as a {@code ProcessMessage}.
   * <p>
   * Uses the underlying persistence mechanism to
   * ensure the {@code sources} are permanent, enabling
   * a backing {@code Exchange} message to be enqueued
   * with guaranteed delivery semantics.
   * @param sources the {@code List<Source<?>>} of source instances to apply
   */
  void emitAll(final List<Source<?>> sources);

  /**
   * Emit the {@code sources} by persisting each as a {@code ProcessMessage},
   * followed by the execution of a possible {@code andThen}.
   * <p>
   * Uses the underlying persistence mechanism to
   * ensure the {@code sources} are permanent, enabling
   * a backing {@code Exchange} message to be enqueued
   * with guaranteed delivery semantics.
   * Emit all {@code sources} by applying them to myself, followed by
   * the execution of a possible {@code andThen}.
   * @param sources the {@code List<Source<?>>} of source instances to apply
   * @param andThen the {@code Supplier<R>} executed following the application of sources
   * @param <R> the return type of the andThen {@code Supplier<R>}
   */
  <R> void emitAll(final List<Source<?>> sources, final Supplier<R> andThen);

  /**
   * Send the {@code command} to my collaborators via my Exchange.
   * <p>
   * Note that this is <strong>not</strong> expected to initially
   * persist the {@code command} to the underlying {@code Journal}.
   * Thus, the {@code command} is subject to the limitations of the
   * underlying {@code Exchange} mechanism, such as downed nodes
   * and network partitions/disconnections.
   * @param command the Command to send
   */
  void send(final Command command);

  /**
   * Send the {@code event} to my collaborators via my Exchange.
   * <p>
   * Note that this is <strong>not</strong> expected to initially
   * persist the {@code event} to the underlying {@code Journal}.
   * Thus, the {@code event} is subject to the limitations of the
   * underlying {@code Exchange} mechanism, such as downed nodes
   * and network partitions/disconnections.
   * @param event the DomainEvent to apply
   */
  void send(final DomainEvent event);
}
