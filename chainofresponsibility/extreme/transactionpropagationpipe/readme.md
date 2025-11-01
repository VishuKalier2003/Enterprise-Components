classDiagram
    interface Chainable {
        +setNext(Chainable next)
        +getNext() Chainable
    }

    interface Command {
        +execute(Context ctx)
        +commit(Context ctx)
        +rollback(Context ctx)
    }

    class HandlerMarker

    class AbstractHandler {
        -Chainable next
        +execute(Context ctx)
        +commit(Context ctx)
        +rollback(Context ctx)
        +setNext(Chainable next)
        +getNext() Chainable
    }

    class ChainManager {
        +addHandler(AbstractHandler handler)
        +buildChain()
    }

    class TransactionManager {
        +begin()
        +executeChain(Context ctx)
        +rollback(String handlerId)
        +commit()
    }

    class PhaseChanger {
        +markPhaseEnd(String phase)
        +beginNewPhase(String phase)
    }

    class Storage {
        +logStatus(String handler, int code)
        +logAction(String handler, String log)
        +getLogs()
    }

    class HandlerRegistry {
        +register(String id, AbstractHandler handler)
        +getHandler(String id)
    }

    HandlerMarker <|.. AbstractHandler
    Chainable <|.. AbstractHandler
    Command <|.. AbstractHandler
    AbstractHandler <|-- PaymentHandler
    AbstractHandler <|-- InventoryHandler
    AbstractHandler <|-- NotificationHandler
    TransactionManager --> ChainManager
    TransactionManager --> Storage
    TransactionManager --> PhaseChanger
    TransactionManager --> HandlerRegistry
