// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.handler;

import java.io.DataOutputStream;
import java.io.DataInputStream;

public abstract class IPacket
{
    public abstract void read(final DataInputStream p0) throws Throwable;
    
    public abstract void write(final DataOutputStream p0) throws Throwable;
    
    public void execute() {
    }
}
