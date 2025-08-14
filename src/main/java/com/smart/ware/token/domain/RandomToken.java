package com.smart.ware.token.domain;

import com.smart.ware.crypto.DrbgStrength;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.DrbgParameters;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public final class RandomToken {
    private static final SecureRandom RNG = initDRBG();
    private static final Logger LOGGER = LoggerFactory.getLogger(RandomToken.class);

    private static final int BIT_SIZE = DrbgStrength.S256.getBits();

    private static final String ALGORITHM_NAME = "DRBG";

    private RandomToken() {
    }

    private static SecureRandom initDRBG() {
        try {
            return SecureRandom.getInstance(ALGORITHM_NAME,
                    DrbgParameters.instantiation(
                            BIT_SIZE, DrbgParameters.Capability.PR_AND_RESEED, null
                    )
            );
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("DRBG 인코딩 에러 발생 {}", e.getMessage());
            return new SecureRandom();
        }
    }

    public static String create32() {
        byte[] bytes = new byte[32];
        RNG.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

}
