// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.lattice.model.sourcing;

import io.vlingo.common.serialization.JsonSerialization;
import io.vlingo.symbio.EntryAdapter;
import io.vlingo.symbio.Metadata;
import io.vlingo.symbio.BaseEntry.TextEntry;

public final class DoCommand2Adapter implements EntryAdapter<DoCommand2,TextEntry> {
  @Override
  public DoCommand2 fromEntry(final TextEntry entry) {
    return JsonSerialization.deserialized(entry.entryData(), DoCommand2.class);
  }

  @Override
  public TextEntry toEntry(final DoCommand2 source) {
    final String serialization = JsonSerialization.serialized(source);
    return new TextEntry(DoCommand2.class, 1, serialization, Metadata.nullMetadata());
  }

  @Override
  public TextEntry toEntry(final DoCommand2 source, final String id) {
    final String serialization = JsonSerialization.serialized(source);
    return new TextEntry(id, DoCommand2.class, 1, serialization, Metadata.nullMetadata());
  }
}
