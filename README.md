Some tests are failing due to incorrect implementation in the Calculator class:

cos: returns `Math.sin(a)` instead of cosine
tg: computes `sin/cos`, but `cos` is actually `sin`, so the result is always 1.0
ctg: returns `Math.tanh(a)` instead of cotangent

The calculations in the assertions are right, but since the Calculator implementation is wrong, the tests fail.