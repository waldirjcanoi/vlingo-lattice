// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.lattice.model.object;

import io.vlingo.common.Completes;
import io.vlingo.lattice.model.TestEvents.Event;

public interface Employee {
  Completes<EmployeeState> current();
  Completes<EmployeeState> assign(final String number);
  Completes<EmployeeState> adjust(final int salary);
  Completes<EmployeeState> hire(final String number, final int salary);


  public static final class EmployeeHired extends Event { }
  public static final class EmployeeSalaryAdjusted extends Event { }
  public static final class EmployeeNumberAssigned extends Event { }
}
