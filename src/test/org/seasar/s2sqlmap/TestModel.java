/*
 * Created on 2005/09/23
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.seasar.s2sqlmap;

import java.util.Date;

 
/**
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public class TestModel
{
    private int hoge;
    
    private String foo;
    
    private Date bar;

    /**
     * @return Returns the foo.
     */
    public String getFoo()
    {
        return foo;
    }
    /**
     * @param foo The foo to set.
     */
    public void setFoo(String foo)
    {
        this.foo = foo;
    }
    /**
     * @return Returns the hoge.
     */
    public int getHoge()
    {
        return hoge;
    }
    /**
     * @param hoge The hoge to set.
     */
    public void setHoge(int hoge)
    {
        this.hoge = hoge;
    }

    /**
     * @return Returns the bar.
     */
    public Date getBar()
    {
        return bar;
    }
    /**
     * @param bar The bar to set.
     */
    public void setBar(Date bar)
    {
        this.bar = bar;
    }
}
