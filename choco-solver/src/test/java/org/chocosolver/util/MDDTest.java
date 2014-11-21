package org.chocosolver.util;

import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.extension.Tuples;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.VF;
import org.chocosolver.util.objects.graphs.MultivaluedDecisionDiagram;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by cprudhom on 04/11/14.
 * Project: Choco3
 */
public class MDDTest {

    @Test(groups = "1s")
    public void test0() {
        Solver solver = new Solver();
        IntVar[] vars = VF.enumeratedArray("X", 4, 0, 2, solver);
        Tuples tuples = new Tuples();
        MultivaluedDecisionDiagram mdd = new MultivaluedDecisionDiagram(vars, tuples);
        Assert.assertEquals(mdd.getDiagram(), new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        mdd = new MultivaluedDecisionDiagram(mdd);
        Assert.assertEquals(mdd.getDiagram(), new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    @Test(groups = "1s")
    public void test1() {
        Solver solver = new Solver();
        IntVar[] vars = VF.enumeratedArray("X", 4, 0, 2, solver);
        Tuples tuples = new Tuples();
        tuples.add(0, 0, 0, 0);
        tuples.add(0, 0, 0, 1);
        tuples.add(0, 0, 1, 0);
        tuples.add(0, 0, 1, 1);
        tuples.add(0, 1, 0, 0);
        tuples.add(0, 1, 0, 1);
        tuples.add(0, 1, 1, 0);
        tuples.add(0, 1, 1, 1);
        tuples.add(2, 2, 2, 2);
        MultivaluedDecisionDiagram mdd = new MultivaluedDecisionDiagram(vars, tuples);
        Assert.assertEquals(mdd.getDiagram(), new int[]{3, 0, 12, 6, 6, 0, 9, 9, 0, -1, -1, 0, 0, 0, 15, 0, 0, 18, 0, 0, -1});
        mdd = new MultivaluedDecisionDiagram(mdd);
        Assert.assertEquals(mdd.getDiagram(), new int[]{3, 0, 12, 6, 6, 0, 9, 9, 0, -1, -1, 0, 0, 0, 15, 0, 0, 18, 0, 0, -1});
    }

    @Test(groups = "1s")
    public void test2() {
        Solver solver = new Solver();
        IntVar[] vars = VF.enumeratedArray("X", 3, 0, 1, solver);
        Tuples tuples = new Tuples();
        tuples.add(0, 0, 0);
        tuples.add(0, 0, 1);
        tuples.add(0, 1, 0);
        tuples.add(0, 1, 1);
        tuples.add(1, 0, 0);
        tuples.add(1, 0, 1);
        tuples.add(1, 1, 0);
        tuples.add(1, 1, 1);
        MultivaluedDecisionDiagram mdd = new MultivaluedDecisionDiagram(vars, tuples);
        Assert.assertEquals(mdd.getDiagram(), new int[]{2, 2, 4, 4, -1, -1});
        mdd = new MultivaluedDecisionDiagram(mdd);
        Assert.assertEquals(mdd.getDiagram(), new int[]{2, 2, 4, 4, -1, -1});
    }

    @Test(groups = "1s")
    public void test3() {
        Solver solver = new Solver();
        IntVar[] vars = new IntVar[2];
        vars[0] = VF.enumerated("X", -1, 0, solver);
        vars[1] = VF.enumerated("Y", new int[]{-1, 2}, solver);
        Tuples tuples = new Tuples();
        tuples.add(0, -1);
        tuples.add(-1, 2);
        MultivaluedDecisionDiagram mdd = new MultivaluedDecisionDiagram(vars, tuples);
        Assert.assertEquals(mdd.getDiagram(), new int[]{6, 2, -1, 0, 0, 0, 0, 0, 0, -1});
        mdd = new MultivaluedDecisionDiagram(mdd);
        Assert.assertEquals(mdd.getDiagram(), new int[]{6, 2, -1, 0, 0, 0, 0, 0, 0, -1});
    }

    @Test(groups = "1s")
    public void test4() {
        Solver solver = new Solver();
        IntVar[] vars = new IntVar[2];
        vars[0] = VF.enumerated("X", 0, 1, solver);
        vars[1] = VF.enumerated("Y", new int[]{-1, 1}, solver);
        Tuples tuples = new Tuples();
        tuples.add(0, -1);
        tuples.add(1, -1);
        tuples.add(0, 1);
        MultivaluedDecisionDiagram mdd = new MultivaluedDecisionDiagram(vars, tuples);
        Assert.assertEquals(mdd.getDiagram(), new int[]{2, 5, -1, 0, -1, -1, 0, 0});
        mdd = new MultivaluedDecisionDiagram(mdd);
        Assert.assertEquals(mdd.getDiagram(), new int[]{2, 5, -1, 0, -1, -1, 0, 0});
    }

}