// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.lattice.model.process;

import io.vlingo.common.serialization.JsonSerialization;
import io.vlingo.lattice.model.process.FiveStepProcess.DoStepFive;
import io.vlingo.lattice.model.process.FiveStepProcess.DoStepFour;
import io.vlingo.lattice.model.process.FiveStepProcess.DoStepOne;
import io.vlingo.lattice.model.process.FiveStepProcess.DoStepThree;
import io.vlingo.lattice.model.process.FiveStepProcess.DoStepTwo;
import io.vlingo.symbio.BaseEntry.TextEntry;
import io.vlingo.symbio.EntryAdapter;
import io.vlingo.symbio.Metadata;

public class EntryAdapters {
  public static final class DoStepOneAdapter implements EntryAdapter<DoStepOne,TextEntry> {
    @Override
    public DoStepOne fromEntry(final TextEntry entry) {
      return JsonSerialization.deserialized(entry.entryData(), DoStepOne.class);
    }

    @Override
    public TextEntry toEntry(final DoStepOne source) {
      final String serialization = JsonSerialization.serialized(source);
      return new TextEntry(DoStepOne.class, 1, serialization, Metadata.nullMetadata());
    }

    @Override
    public TextEntry toEntry(final DoStepOne source, final String id) {
      final String serialization = JsonSerialization.serialized(source);
      return new TextEntry(id, DoStepOne.class, 1, serialization, Metadata.nullMetadata());
    }
  }

  public static final class DoStepTwoAdapter implements EntryAdapter<DoStepTwo,TextEntry> {
    @Override
    public DoStepTwo fromEntry(final TextEntry entry) {
      return JsonSerialization.deserialized(entry.entryData(), DoStepTwo.class);
    }

    @Override
    public TextEntry toEntry(final DoStepTwo source) {
      final String serialization = JsonSerialization.serialized(source);
      return new TextEntry(DoStepTwo.class, 1, serialization, Metadata.nullMetadata());
    }

    @Override
    public TextEntry toEntry(final DoStepTwo source, final String id) {
      final String serialization = JsonSerialization.serialized(source);
      return new TextEntry(id, DoStepTwo.class, 1, serialization, Metadata.nullMetadata());
    }
  }

  public static final class DoStepThreeAdapter implements EntryAdapter<DoStepThree,TextEntry> {
    @Override
    public DoStepThree fromEntry(final TextEntry entry) {
      return JsonSerialization.deserialized(entry.entryData(), DoStepThree.class);
    }

    @Override
    public TextEntry toEntry(final DoStepThree source) {
      final String serialization = JsonSerialization.serialized(source);
      return new TextEntry(DoStepThree.class, 1, serialization, Metadata.nullMetadata());
    }

    @Override
    public TextEntry toEntry(final DoStepThree source, final String id) {
      final String serialization = JsonSerialization.serialized(source);
      return new TextEntry(id, DoStepThree.class, 1, serialization, Metadata.nullMetadata());
    }
  }

  public static final class DoStepFourAdapter implements EntryAdapter<DoStepFour,TextEntry> {
    @Override
    public DoStepFour fromEntry(final TextEntry entry) {
      return JsonSerialization.deserialized(entry.entryData(), DoStepFour.class);
    }

    @Override
    public TextEntry toEntry(final DoStepFour source) {
      final String serialization = JsonSerialization.serialized(source);
      return new TextEntry(DoStepFour.class, 1, serialization, Metadata.nullMetadata());
    }

    @Override
    public TextEntry toEntry(final DoStepFour source, final String id) {
      final String serialization = JsonSerialization.serialized(source);
      return new TextEntry(id, DoStepFour.class, 1, serialization, Metadata.nullMetadata());
    }
  }

  public static final class DoStepFiveAdapter implements EntryAdapter<DoStepFive,TextEntry> {
    @Override
    public DoStepFive fromEntry(final TextEntry entry) {
      return JsonSerialization.deserialized(entry.entryData(), DoStepFive.class);
    }

    @Override
    public TextEntry toEntry(final DoStepFive source) {
      final String serialization = JsonSerialization.serialized(source);
      return new TextEntry(DoStepFive.class, 1, serialization, Metadata.nullMetadata());
    }

    @Override
    public TextEntry toEntry(final DoStepFive source, final String id) {
      final String serialization = JsonSerialization.serialized(source);
      return new TextEntry(id, DoStepFive.class, 1, serialization, Metadata.nullMetadata());
    }
  }
}
