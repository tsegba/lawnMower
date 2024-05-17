package kata.lawnmower.app.adapter.impl;

import kata.lawnmower.app.adapters.TextFileAdapter;
import kata.lawnmower.app.adapters.impl.TextFileAdapterImpl;
import kata.lawnmower.domain.enums.Orientation;
import kata.lawnmower.domain.model.Lawn;
import kata.lawnmower.domain.model.Mower;
import kata.lawnmower.domain.service.LawnMowerService;
import kata.lawnmower.domain.service.impl.LawnMowerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TextFileAdapterTest {

    LawnMowerService lawnMowerService;
    TextFileAdapter textFileAdapter;

    @BeforeEach
    void initParameter() {
        lawnMowerService = new LawnMowerServiceImpl();
        textFileAdapter = new TextFileAdapterImpl(lawnMowerService);
    }



}
