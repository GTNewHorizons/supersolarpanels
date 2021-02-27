
package com.Denfop.DamageSource;

import net.minecraft.util.DamageSource;

public class SSPDamageSource extends DamageSource
{
    public static final SSPDamageSource current;

    public SSPDamageSource(final String s) {
        super(s);
    }
    
    static {
   
        current = (SSPDamageSource)new SSPDamageSource(("current")).setDamageBypassesArmor();
        
    }
    

}
