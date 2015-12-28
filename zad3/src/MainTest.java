import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class MainTest {

    @Test
    public void testEmptyListCreation()
    {
        TripleList<Integer> tripleList = new TripleList<>();
        assertEquals(0, tripleList.Count());
        assertNull(tripleList.PreviousElement());
        assertNull(tripleList.MiddleElement());
        assertNull(tripleList.NextElement());
    }

    @Test
    public void testAddingSingleElement()
    {
        TripleList<Integer> tripleList = new TripleList<>();
        final Integer value = 4;
        tripleList.add(value);
        assertEquals(1, tripleList.Count());
        assertEquals(value, tripleList.Value());
        assertNull(tripleList.PreviousElement());
        assertNull(tripleList.MiddleElement());
        assertNull(tripleList.NextElement());
    }

    @Test
    public void testAddingTwoElements()
    {
        TripleList<Integer> tripleList = new TripleList<>();
        Integer value1 = 4;
        Integer value2 = -9;
        tripleList.add(value1);
        tripleList.add(value2);
        assertEquals(2, tripleList.Count());
        // checking values
        assertEquals(value1, tripleList.Value());
        assertEquals(value2, tripleList.MiddleElement().Value());
        assertEquals(tripleList.Value(), tripleList.MiddleElement().MiddleElement().Value());
        // checking neighbour Nodes of first element
        assertNull(tripleList.PreviousElement());
        assertNotNull(tripleList.MiddleElement());
        assertNull(tripleList.NextElement());
        // checking neighbour Nodes of second element
        assertNull(tripleList.MiddleElement().PreviousElement());
        assertNull(tripleList.MiddleElement().NextElement());
    }

    @Test
    public void testAddingTreeElements()
    {
        TripleList<Integer> tripleList = new TripleList<>();
        Integer value1 = 4;
        Integer value2 = -9;
        Integer value3 = 47;
        tripleList.add(value1);
        tripleList.add(value2);
        tripleList.add(value3);
        assertEquals(3, tripleList.Count());
        // checking values
        assertEquals(value1, tripleList.Value());
        assertEquals(value2, tripleList.MiddleElement().Value());
        assertEquals(value3, tripleList.NextElement().Value());
        // checking neighbour Nodes of first element
        assertNull(tripleList.PreviousElement());
        assertNotNull(tripleList.MiddleElement());
        assertNotNull(tripleList.NextElement());
        // checking neighbour Nodes of second element
        assertNull(tripleList.MiddleElement().PreviousElement());
        assertNotNull(tripleList.MiddleElement().MiddleElement());
        assertNull(tripleList.MiddleElement().NextElement());
        // checking neighbour Nodes of third/last element
        assertNotNull(tripleList.NextElement().PreviousElement());
        assertNull(tripleList.NextElement().MiddleElement());
        assertNull(tripleList.NextElement().NextElement());
        // checking values
        assertEquals(value1, tripleList.Value());
        assertEquals(value2, tripleList.MiddleElement().Value());
        assertEquals(value3, tripleList.NextElement().Value());
    }

    @Test
    public void testAddingFiveElements()
    {
        TripleList<Integer> tripleList = new TripleList<>();
        int value1 = 1;
        int value2 = 2;
        int value3 = 3;
        int value4 = 4;
        int value5 = 5;
        tripleList.add(value1);
        tripleList.add(value2);
        tripleList.add(value3);
        tripleList.add(value4);
        tripleList.add(value5);
        assertEquals(5, tripleList.Count());
        // checking values
        assertEquals(value1, (int)tripleList.Value());
        assertEquals(value2, (int)tripleList.MiddleElement().Value());
        assertEquals(value3, (int)tripleList.NextElement().Value());
        assertEquals(value4, (int)tripleList.NextElement().MiddleElement().Value());
        assertEquals(value5, (int)tripleList.NextElement().NextElement().Value());
    }

    @Test
    public void testListsEnumerator()
    {
        Double[] values = { 1.1, 3.14, 6.13, 9.99999, 99.001 };
        TripleList<Double> tripleList = new TripleList<>();
        int i;
        for (i = 0; i < values.length; ++i)
        {
            tripleList.add(values[i]);
        }
        i = 0;
        for (Double d : tripleList)
        {
            assertEquals(values[i++], d);
        }
    }

    @Test
    public void testListsEnumerator2()
    {
        Double[] values = { 1.1, 3.14, 6.13, 9.99999, 99.001 };
        TripleList<Double> tripleList = new TripleList<>();
        int i;
        for (i = 0; i < values.length; ++i)
        {
            tripleList.add(values[i]);
        }
        i = 0;
        Iterator<Double> iterator = tripleList.getIterator();
        while (iterator.hasNext())
        {
            assertEquals(values[i++], iterator.next());
        }
    }

    @Test
    public void testIfNoCycle()
    {
        /** Initialization of the TripleList **/
        final int NUMBER_OF_ELEMENTS = 100;
        TripleList<Integer> tripleList = new TripleList<>();
        for (int i = 0; i < NUMBER_OF_ELEMENTS; ++i)
        {
            tripleList.add(i);
        }
        /** Created 2 TripleLists, first jumps every single element,
         another every two elements, in out case every two elements means every NextElement**/
        TripleList<Integer> tripleListEverySingleNode = tripleList;
        TripleList<Integer> tripleListEveryTwoNodes = tripleList.NextElement();
        for (int i = 0; i < NUMBER_OF_ELEMENTS * NUMBER_OF_ELEMENTS; ++i)
        {
            assertNotSame(tripleListEverySingleNode, tripleListEveryTwoNodes);
            jumpToNextElement(tripleListEverySingleNode);
            if (null == tripleListEveryTwoNodes.NextElement())
            {
                // if list has end means there are no cycles
                break;
            }
            else
            {
                tripleListEveryTwoNodes = tripleListEveryTwoNodes.NextElement();
            }
        }
    }

    @Test
    public void arrayInitializers() {
        TripleList<Integer> tl1 = new TripleList<>();
        tl1.add(5);
        tl1.add(10);
        tl1.add(15);
        TripleList<Integer> tl2 = new TripleList<>();
        tl2.add(0);
        tl2.add(tl1);
        tl2.add(20);
        assertEquals(3, tl1.Count());
        assertEquals(5, tl2.Count());
        assertEquals(tl1.Value(), tl2.MiddleElement().Value());
        List<Integer> tl1Sorted  = tl1.toList();
        Collections.sort(tl1Sorted);
        List<Integer> tl2Sorted = tl2.toList();
        Collections.sort(tl1Sorted);
        for (int i = 0; i < tl1Sorted.size(); ++i) {
            assertEquals(tl1Sorted.get(i), tl2Sorted.get(i+1));
        }
    }

    private void jumpToNextElement(TripleList<Integer> ele)
    {
        if (IsNotLastElement(ele))
        {
            if (IsMiddleElement(ele))
            {
                if (null != ele.MiddleElement().NextElement())
                {
                    ele = ele.MiddleElement().NextElement();
                }
            }
            else
            {
                if (null != ele.NextElement())
                {
                    ele = ele.NextElement();
                }
            }
        }
    }

    private boolean IsNotLastElement(TripleList<Integer> element)
    {
        return null != element.MiddleElement();
    }

    private boolean IsMiddleElement(TripleList<Integer> element)
    {
        return null == element.NextElement() && null == element.PreviousElement() && null != element.MiddleElement();
    }
}