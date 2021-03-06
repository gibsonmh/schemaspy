package org.schemaspy.testing;

import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.ComparisonResult;
import org.xmlunit.diff.DifferenceEvaluator;

import java.util.Objects;

public class IgnoreUsingXPath implements DifferenceEvaluator{

    private final String xPath;

    public IgnoreUsingXPath(String xPath) {
        this.xPath = xPath;
    }

    @Override
    public ComparisonResult evaluate(Comparison comparison, ComparisonResult outcome) {
        if (outcome == ComparisonResult.EQUAL) return outcome;
        String xPath = comparison.getTestDetails().getXPath();
        if (Objects.nonNull(xPath) && xPath.equals(xPath)) {
            return ComparisonResult.EQUAL;
        }
        return outcome;
    }
}
