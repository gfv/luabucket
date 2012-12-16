package md.zoidberg.luabucket2.util;

import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

import java.io.File;

public class SnipLoader {
    private LuaFunction loader;
    private Integer loadCounter = 0;

    public SnipLoader(LuaFunction loader) {
        this.loader = loader;
    }

    public void load(File f) {
        load(f, f.getName());
    }

    public void load(File f, String name) {
        LuaTable snip = new LuaTable();
        snip.set("name", name);
        snip.set("path", CoerceJavaToLua.coerce(f.getAbsolutePath()));
        loader.call(snip);
    }

    public void load(String s) {
        load(s, "dynamic#" + loadCounter.toString());
    }

    public void load(String s, String name) {
        LuaTable snip = new LuaTable();
        snip.set("name", name);
        snip.set("string", s);
        loader.call(snip);
        loadCounter++;
    }
}