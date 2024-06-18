package io.type.pollution.agent;

import jdk.jfr.Category;
import jdk.jfr.Description;
import jdk.jfr.Enabled;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;
import jdk.jfr.StackTrace;

@Name(TypeCheckThrashEvent.NAME)
@Label("Type check cache thrashing")
@Category("Type check")
@Description("An interface type check is invalidating a previously cached type check result. If this happens often, it can lead to thrashing and contention of the cache field.")
@StackTrace
@Enabled(false)
public class TypeCheckThrashEvent extends Event {
    static final String NAME = "io.type.pollution.agent.TypeCheckThrashEvent";

    @Label("Concrete type")
    @Description("Concrete class of the object that was type checked (the thrashed cache field is stored in this class)")
    public String concreteClass;

    @Label("Interface type")
    @Description("Interface that this object was checked against (this is the type that is stored in the thrashed cache field)")
    public String interfaceClass;
}
