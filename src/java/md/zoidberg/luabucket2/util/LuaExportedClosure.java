package md.zoidberg.luabucket2.util;

import org.luaj.vm2.LuaFunction;

public class LuaExportedClosure {
    private LuaFunction closure;
    private String snip;

    public LuaExportedClosure(LuaFunction closure, String snip) {
        this.closure = closure;
        this.snip = snip;
    }

    public LuaFunction getClosure() {
        return this.closure;
    }

    public String getSnip() {
        return this.snip;
    }
}
