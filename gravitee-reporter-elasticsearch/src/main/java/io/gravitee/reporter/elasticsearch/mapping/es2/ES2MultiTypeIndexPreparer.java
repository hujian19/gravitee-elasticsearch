/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.reporter.elasticsearch.mapping.es2;

import io.gravitee.reporter.elasticsearch.mapping.AbstractIndexPreparer;
import io.reactivex.Completable;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
public class ES2MultiTypeIndexPreparer extends AbstractIndexPreparer {

    @Override
    public Completable prepare() {
        final String templateName = configuration.getIndexName();

        logger.debug("Trying to put template mapping [{}] name[{}]", templateName);

        final String template = freeMarkerComponent.generateFromTemplate(
                "/es2x/mapping/index-template.ftl", getTemplateData());

        return client.putTemplate(templateName, template);
    }
}
