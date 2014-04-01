/*
 * Copyright 2013 original author or authors.
 *
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
 */
package pl.allegro.tdr.gruntmaven;

import java.util.Arrays;
import java.util.List;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import pl.allegro.tdr.gruntmaven.executable.Executable;

/**
 * Executes bower install to download all dependencies declared in bower.json.
 */
@Mojo(name = "bower", defaultPhase = LifecyclePhase.TEST)
public class ExecBowerMojo extends AbstractExecutableMojo {

    private static final String BOWER_INSTALL_COMMAND = "install";

    /**
     * Name of bower executable in PATH, defaults to bower.
     */
    @Parameter(property = "bowerExecutable", defaultValue = "bower")
    private String bowerExecutable;

    @Override
    protected List<Executable> getExecutables() {
        Executable executable = new Executable(bowerExecutable);

        executable.addArgument(BOWER_INSTALL_COMMAND);
        if (!showColors) {
            executable.addArgument("--color=false");
        }

        return Arrays.asList(executable);
    }
}