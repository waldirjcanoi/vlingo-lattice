// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.lattice.model.process;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import io.vlingo.actors.World;
import io.vlingo.lattice.exchange.Exchange;
import io.vlingo.lattice.exchange.NullExchange;
import io.vlingo.lattice.model.object.ObjectTypeRegistry;
import io.vlingo.lattice.model.sourcing.SourcedTypeRegistry;
import io.vlingo.lattice.model.stateful.StatefulTypeRegistry;

/**
 * Registry for {@code Process} types.
 */
public final class ProcessTypeRegistry {
  static final String INTERNAL_NAME = UUID.randomUUID().toString();

  private final Map<Class<?>,Info<?>> stores = new HashMap<>();

  /**
   * Construct my default state and register me with the {@code world}.
   * @param world the World to which I am registered
   */
  public ProcessTypeRegistry(final World world) {
    world.registerDynamic(INTERNAL_NAME, this);
  }

  /**
   * Answer the {@code Info<T>} of the {@code type}.
   * @param type the {@code Class<?>} identifying the desired {@code Info<T>}
   * @param <T> the type of Object in the ObjectStore
   * @return {@code Info<T>}
   */
  @SuppressWarnings("unchecked")
  public <T> Info<T> info(Class<?> type) {
    return (Info<T>) stores.get(type);
  }

  /**
   * Answer myself after registering the {@code info}.
   * @param info the {@code Info<?>} to register
   * @return ObjectTypeRegistry
   */
  public ProcessTypeRegistry register(final Info<?> info) {
    stores.put(info.processType, info);
    return this;
  }

  /**
   * Holder of registration information.
   * @param <T> the type of Process of the registration
   */
  public static abstract class Info<T> {
    public final Exchange exchange;
    public final String processName;
    public final Class<T> processType;

    /**
     * Construct my default state.
     * @param processType the {@code Class<T>} Process type
     * @param processName the String name of the Process
     * @param exchange the Exchange
     */
    public Info(final Class<T> processType, final String processName, final Exchange exchange) {
      this.processType = processType;
      this.processName = processName;
      this.exchange = exchange;
    }

    /**
     * Construct my default state.
     * @param processType the {@code Class<T>} Process type
     * @param processName the String name of the Process
     */
    public Info(final Class<T> processType, final String processName) {
      this(processType, processName, NullExchange.Instance);
    }
  }

  /**
   * Holder of registration information for {@code ObjectProcess} types.
   */
  public static class ObjectProcessInfo extends Info<ObjectProcess<?>> {
    public final ObjectTypeRegistry registry;

    /**
     * Construct my default state.
     * @param processType the {@code Class<ObjectProcess<?>>} Process type
     * @param processName the String name of the Process
     * @param exchange the Exchange
     * @param registry the ObjectTypeRegistry used by the ObjectEntityProcess
     */
    public ObjectProcessInfo(final Class<ObjectProcess<?>> processType, final String processName, final Exchange exchange, final ObjectTypeRegistry registry) {
      super(processType, processName, exchange);
      this.registry = registry;
    }

    /**
     * Construct my default state.
     * @param processType the {@code Class<ObjectProcess<?>>} Process type
     * @param processName the String name of the Process
     * @param registry the ObjectTypeRegistry used by the ObjectEntityProcess
     */
    public ObjectProcessInfo(final Class<ObjectProcess<?>> processType, final String processName, final ObjectTypeRegistry registry) {
      super(processType, processName);
      this.registry = registry;
    }
  }

  /**
   * Holder of registration information for {@code SourcedProcess} types.
   */
  public static class SourcedProcessInfo<T extends SourcedProcess<T>> extends Info<T> {
    public final SourcedTypeRegistry registry;

    /**
     * Construct my default state.
     * @param processType the {@code Class<SourcedProcess>} Process type
     * @param processName the String name of the Process
     * @param exchange the Exchange
     * @param registry the SourcedTypeRegistry used by the SourcedProcess
     */
    public SourcedProcessInfo(final Class<T> processType, final String processName, final Exchange exchange, final SourcedTypeRegistry registry) {
      super(processType, processName, exchange);
      this.registry = registry;
    }

    /**
     * Construct my default state.
     * @param processType the {@code Class<SourcedProcess>} Process type
     * @param processName the String name of the Process
     * @param registry the SourcedProcessInfo used by the ObjectEntityProcess
     */
    public SourcedProcessInfo(final Class<T> processType, final String processName, final SourcedTypeRegistry registry) {
      super(processType, processName);
      this.registry = registry;
    }
  }

  /**
   * Holder of registration information for {@code StatefulProcess} types.
   * @param <T> the type of StatefulProcess of the registration
   */
  public static class StatefulProcessInfo<T> extends Info<StatefulProcess<T>> {
    public final StatefulTypeRegistry registry;

    /**
     * Construct my default state.
     * @param processType the {@code Class<StatefulProcess<T>>} Process type
     * @param processName the String name of the Process
     * @param exchange the Exchange
     * @param registry the StatefulTypeRegistry used by the SourcedProcess
     */
    public StatefulProcessInfo(final Class<StatefulProcess<T>> processType, final String processName, final Exchange exchange, final StatefulTypeRegistry registry) {
      super(processType, processName, exchange);
      this.registry = registry;
    }

    /**
     * Construct my default state.
     * @param processType the {@code Class<StatefulProcess<T>>} Process type
     * @param processName the String name of the Process
     * @param registry the StatefulTypeRegistry used by the ObjectEntityProcess
     */
    public StatefulProcessInfo(final Class<StatefulProcess<T>> processType, final String processName, final StatefulTypeRegistry registry) {
      super(processType, processName);
      this.registry = registry;
    }
  }
}
