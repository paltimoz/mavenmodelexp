package com.paltimoz;

import com.paltimoz.soap.client.Add;
import com.paltimoz.soap.client.AddResponse;
import com.paltimoz.soap.client.MultiplyResponse;
import com.paltimoz.soap.client.ObjectFactory;
import com.paltimoz.soap.client.Multiply;

public class Calculate {

    ObjectFactory factory = new ObjectFactory();

    public AddResponse add(int a, int b){
        Add add = factory.createAdd();
        add.setIntA(a);
        add.setIntB(b);
        return new AddResponse();
    }

    public MultiplyResponse multiply(int a, int b){
        Multiply multiply = factory.createMultiply();
        multiply.setIntA(a);
        multiply.setIntB(b);
        return new MultiplyResponse();
    }
}
