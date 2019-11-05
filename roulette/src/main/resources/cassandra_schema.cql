create keyspace roulette WITH REPLICATION = {
    'class' : 'SimpleStrategy',
    'replication_factor' : 2
};

use roulette;

CREATE TABLE game (
    id UUID PRIMARY KEY,
    user_id UUID,
    cash_in bigint,
    cash_out bigint,
    bet_map map<text, bigint>,
    win_map map<text, bigint>
);
