create keyspace roulette WITH REPLICATION = {
    'class' : 'SimpleStrategy',
    'replication_factor' : 2
    };

use roulette;

CREATE TABLE game (
                      id UUID PRIMARY KEY,
                      userId UUID,
                      cashIn bigint,
                      cashOut bigint,
                      bets set<text>,
                      win boolean
);
