package ru.sfedu.simpleBuilder.util;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "list")
public class XmlWrap<T> {
    @ElementList(inline = true, required = false)
    private List<T> list;

    public XmlWrap() {
    }

    public XmlWrap(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
