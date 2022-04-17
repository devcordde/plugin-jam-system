package com.github.devcordde.pluginjamsystem.exceptions;

import java.util.List;

public class RegistrationNeedsResolverException extends Exception {
    private final List<String> nonConfiguredResolvers;

    public RegistrationNeedsResolverException(List<String> nonConfiguredResolvers) {
        super(String.format(
                        "Following reolvers needs to be configured: %s",
                        String.join(", ", nonConfiguredResolvers)
                )
        );
        this.nonConfiguredResolvers = nonConfiguredResolvers;
    }

    public List<String> nonConfiguredResolvers() {
        return nonConfiguredResolvers;
    }
}
