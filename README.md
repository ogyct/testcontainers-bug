Resolved. It turns out to be a postgres behavior. current_timestamp inside tracsaction will return the time of the transation beginning. Use `clock_timestamp()` instead.
