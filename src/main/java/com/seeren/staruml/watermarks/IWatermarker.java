package com.seeren.staruml.watermarks;

import java.io.File;

public interface IWatermarker {

    public void mark(final File file) throws RuntimeException;

    public void unmark(final File file) throws RuntimeException;

}
