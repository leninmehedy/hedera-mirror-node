package com.hedera.mirror.importer.repository;

/*-
 * ‌
 * Hedera Mirror Node
 * ​
 * Copyright (C) 2019 - 2020 Hedera Hashgraph, LLC
 * ​
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ‍
 */

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.hedera.mirror.importer.domain.EntityId;
import com.hedera.mirror.importer.domain.EntityTypeEnum;
import com.hedera.mirror.importer.domain.FileData;
import com.hedera.mirror.importer.domain.Transaction;
import com.hedera.mirror.importer.domain.TransactionTypeEnum;

public class FileDataRepositoryTest extends AbstractRepositoryTest {

    @Test
    void insert() {
        Transaction transaction = insertTransaction("FILECREATE");

        FileData fileData = new FileData();
        fileData.setConsensusTimestamp(transaction.getConsensusNs());
        fileData.setFileData("some file data".getBytes());
        fileData.setEntityId(EntityId.of("0.0.123", EntityTypeEnum.FILE));
        fileData.setTransactionType(TransactionTypeEnum.FILECREATE.getProtoId());
        fileData = fileDataRepository.save(fileData);

        Assertions.assertThat(fileDataRepository.findById(transaction.getConsensusNs()).get())
                .isNotNull()
                .isEqualTo(fileData);
    }
}
