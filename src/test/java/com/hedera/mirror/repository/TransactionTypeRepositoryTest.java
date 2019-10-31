package com.hedera.mirror.repository;

/*-
 * ‌
 * Hedera Mirror Node
 * ​
 * Copyright (C) 2019 Hedera Hashgraph, LLC
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

import org.junit.jupiter.api.Test;
import com.hedera.mirror.domain.TransactionType;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionTypeRepositoryTest extends AbstractRepositoryTest {

    @Test
    void findByName() {
    	assertThat(transactionTypeRepository.findByName("CRYPTOADDCLAIM"))
    		.isPresent()
    		.get()
    		.extracting(TransactionType::getId)
    		.isNotEqualTo(0L);    	
    }
}