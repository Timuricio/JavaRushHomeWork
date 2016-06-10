package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timur on 26.05.2016.
 */

@XmlType(name = "shop")
@XmlRootElement
public class Shop
{
    @XmlElementWrapper(nillable = true, name = "goods")
    public List<String> names = new ArrayList<>();
    public int count;
    public double profit;
    public String[] secretData = new String[5];

    public Shop()
    {
    }
}
