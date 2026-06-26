package org.autumn.euphoriant.core.index;

import net.acoyt.acornlib.api.registrants.ItemRegistrant;

import static org.autumn.euphoriant.core.Euphoriant.MOD_ID;

public interface ModItems {
    ItemRegistrant rant = new ItemRegistrant(MOD_ID);



    static void init() {}
}
