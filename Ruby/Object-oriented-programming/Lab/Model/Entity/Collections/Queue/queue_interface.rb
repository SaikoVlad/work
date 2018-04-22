require_relative "../../../../Model/Entity/Collections/abstract_collection"
class QueueInterface < AbstractCollection

  def enqueue(element)
  end

  def dequeue
  end

  def peek
  end

end